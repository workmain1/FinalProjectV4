package com.example.finalprojectv2;


import java.util.List;

public class BinarySearch {
    public static int search(List<Satellite> list, String targetName) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = list.get(mid).getName().compareToIgnoreCase(targetName);
            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

