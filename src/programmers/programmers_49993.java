package programmers;

public class programmers_49993 {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;
        int[] list = new int[26]; //스킬트리

        int idx = 1; //스킬트리 시작 레벨
        for (char c : skill.toCharArray()){
            list[(int)(c-'A')] = idx++;
        }

        for(String s : skill_trees){
            char[] cur = s.toCharArray();//유저 스킬트리
            int size = cur.length; //유저 스킬트리 사이즈
            int lv = 1; //유저 레벨
            boolean flag = true;

            for (int i = 0; i <size; i++) {

                int demand = list[(int)(cur[i]-'A')];
                //스킬트리랑 관계없는 스킬이면 스킵
                if(demand == 0) continue;

                if(demand ==lv)
                    lv++; //해당 스킬 배웠음
                else{// 스킬트리에 맞지 않음
                    flag = false;
                    break;
                }
            }
            if(flag)
                answer++;
        }
        return answer;
    }
}
