package programmers;

public class programmers_42840 {
    public static int[] solution(int[] answers) {

        int[] li1 = {1,2,3,4,5};
        int[] li2 = {2,1,2,3,2,4,2,5};
        int[] li3 = {3,3,1,1,2,2,4,4,5,5};

        int idx = 0;

        int[] ans= new int[3];

        for(int num : answers){
            if(num == li1[idx%5]){
                ans[0]++;
            }
            if(num == li2[idx%8]){
                ans[1]++;
            }
            if(num == li3[idx%10]) {
                ans[2]++;
            }
            idx++;
        }

        if(ans[0] == ans[1]&& ans[1] == ans[2]){
            return new int[]{1,2,3};
        } else if (ans[0]==ans[1] && ans[1] >ans[2]) {
            return new int[]{1,2};
        } else if (ans[1]==ans[2] && ans[1] >ans[0]) {
            return new int[]{2,3};
        }else if (ans[2]==ans[0] && ans[2] >ans[1]) {
            return new int[]{1,3};
        } else if (ans[0]>ans[1]&&ans[0]>ans[2]) {
            return new int[]{1};
        }else if (ans[1]>ans[2]&&ans[1]>ans[0]) {
            return new int[]{2};
        }
        else if (ans[2]>ans[1]&&ans[2]>ans[0]) {
            return new int[]{3};
        }
        return null;
    }

    public static void main(String[] args) {
        solution(new int[]{1, 3, 2, 4, 2});
    }
}
