class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Case 1: Found target
            if (nums[mid] == target) return mid;

            // Case 2: Left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if target lies in the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Move left
                } else {
                    left = mid + 1; // Move right
                }
            }
            // Case 3: Right half is sorted
            else {
                // Check if target lies in the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Move right
                } else {
                    right = mid - 1; // Move left
                }
            }
        }

        // If we exit loop, target not found
        return -1;
    }
}
