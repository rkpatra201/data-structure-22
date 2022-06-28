package v1.dp;

public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        // 2  ans[0]
        // 2, 7 max(2,7) = ans[1]
        // 2,7,9 max(arr[2] + ans[0], ans[1]) = max(arr[i]+ans[i-2], ans[i-1])

        int result = 0;
        if (arr.length == 0)
            result = 0;
        if (arr.length == 1)
            result = arr[0];
        if (arr.length == 2)
            result = Math.max(arr[0], arr[1]);

        int[] ans = new int[arr.length];
        ans[0] = arr[0];
        ans[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i< arr.length;i++ )
        {
            ans[i] = Math.max(arr[i]+ans[i-2], ans[i-1]);
        }
        result = ans[arr.length -1];
        System.out.println(result);

    }
}
