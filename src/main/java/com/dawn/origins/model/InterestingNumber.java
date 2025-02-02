package com.dawn.origins.model;

import java.util.ArrayList;

public record InterestingNumber(
                int number,
                Boolean is_prime,
                Boolean is_perfect,
                ArrayList<String> properties,
                int digit_sum,
                String fun_fact) {

}
