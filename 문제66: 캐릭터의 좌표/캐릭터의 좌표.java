class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x=0;
        int y=0;

        int limit_x = board[0]/2;
        int limit_y = board[1]/2;

        for(String command : keyinput){
            int new_x = x;
            int new_y = y;
            if(command.equals("left")){
                new_x--;
            }else if(command.equals("right")){
                new_x++;
            }else if(command.equals("up")){
                new_y++;
            }else{
                new_y--;
            }

            if(new_x < -limit_x || new_x > limit_x || new_y < -limit_y || new_y > limit_y ){
                continue;
            }

            x= new_x;
            y= new_y;
        }

        return new int[]{x,y};
    }
}