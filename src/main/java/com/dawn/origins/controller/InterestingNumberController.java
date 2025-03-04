package com.dawn.origins.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dawn.origins.model.InterestingNumber;
import com.dawn.origins.model.InterestingNumberApiErrorResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class InterestingNumberController {

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    private boolean isArmstrongNumber(int number) {
        int sum = 0;
        int temp = number;
        int length = String.valueOf(number).length();
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, length);
            temp /= 10;
        }
        return sum == number;
    }

    private ArrayList<String> getProperties(int number) {
        ArrayList<String> properties = new ArrayList<String>();
        if (isArmstrongNumber(number)) {
            properties.add("armstrong");
        }
        if (number % 2 == 0) {
            properties.add("even");
        } else {
            properties.add("odd");
        }

        return properties;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private String getFunFact(int number) {
        try {
            String apiUrl = "http://numbersapi.com/" + number + "/math"; // Sample API
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = br.readLine()) != null) {
                response.append(output);
            }

            conn.disconnect();
            System.out.println("Response: " + response.toString());
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "No fun fact available for" + number;
        }
    }

    @Operation(summary = "Get Interesting Facts about a number", description = "Returns a successful schema or an error response")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful Response", content = @Content(schema = @Schema(implementation = InterestingNumber.class))),
            @ApiResponse(responseCode = "400", description = "Error Response", content = @Content(schema = @Schema(implementation = InterestingNumberApiErrorResponse.class)))
    })
    @CrossOrigin(origins = "*")
    @GetMapping("/api/classify-number")
    public ResponseEntity<?> classifyNumber(@RequestParam(value = "number", defaultValue = "1") String numberStr) {
        try {
            int number = Integer.parseInt(numberStr);
            InterestingNumber response = new InterestingNumber(
                    Integer.parseInt(numberStr),
                    isPrime(number),
                    isPerfect(number),
                    getProperties(Math.abs(number)),
                    getDigitSum(Math.abs(number)),
                    getFunFact(number));

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number" + numberStr);
            var response = new InterestingNumberApiErrorResponse(numberStr, true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
