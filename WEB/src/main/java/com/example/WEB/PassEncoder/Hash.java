package com.example.WEB.PassEncoder;

public class Hash {
    public static String  HashPassword( String input) {
        final int FNV_prime = 0x1000193;
        final int FNV_offset_basic = 0x811C9DC5;
        int hash = FNV_offset_basic;
        for (int i = 0; i < input.length(); i++) {
            char byte_of_data = input.charAt(i);
            hash ^= byte_of_data;
            hash *= FNV_prime;
        }
        return Integer.toHexString(hash);
    }
}
