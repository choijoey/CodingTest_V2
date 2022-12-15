public class test {
    static void permu(String s){
        permu(s,"");
    }
    static void permu(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
        }
        else{
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0,i) + str.substring(i+1);
                permu(rem,prefix + str.charAt(i));
            }
        }
    }
    public static void main(String[] args) {
        permu("abcdefg");

    }
}
