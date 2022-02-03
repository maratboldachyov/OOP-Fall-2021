import java.util.*;
/*
Enter your code here.
Create all the necessary classes and methods as per the requirements.
*/


class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public boolean equals(Position position) {
        if (this == position)
            return true;
        else if (position == null || getClass() != position.getClass())
            return false;
        else
            return x == position.x && y == position.y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }
}

interface Player{
    Position getPosition();
    void setMap(Map map);
    void moveDown();
    void moveUp();
    void moveLeft();
    void moveRight();
}

class MyPlayer implements Player{
    private Map map;
    private int width;
    private Position pos;
    MyPlayer(){}
    @Override
    public Position getPosition(){
        Position playerPosition = new Position(pos.getY(), pos.getX());
        return playerPosition;
    }

    @Override
    public void setMap(Map map) {
        this.map = map;
        width = this.map.getSize();
        int y = 0;
        int x = 0;
        space(y, x);
    }

    void space(int y, int x) {
        if (x != width - 1) {
            if (map.getValueAt(y, x) == 'P') {
                pos = new Position(y, x);
            } else {
                space(y, x + 1);
            }
        } else if(y != width -1 && x == width -1){
            if (map.getValueAt(y, x) == 'P') {
                pos = new Position(y, x);
            } else {
                space(y+1, 0);
            }
        }else if(y == width -1 && x == width -1){
            if (map.getValueAt(y, x) == 'P') {
                pos = new Position(y, x);
            }
        }
    }
    @Override
    public void moveDown(){
        try {
            int curX = (int) pos.getX();
            if (curX == width) {
            } else {
                if (map.getValueAt(curX + 1, pos.getY()) != '1') {
                    pos.setX(curX + 1);
                }
            }
        }catch (Exception ex){}
    }
    @Override
    public void moveUp(){
        try {
            int curX = (int) pos.getX();
            if (curX == 0) {
            } else {
                if (map.getValueAt(curX - 1, pos.getY()) != '1') {
                    pos.setX(curX - 1);
                }
            }
        }catch (Exception ex){}
    }
    @Override
    public void moveLeft(){
        try {
            int curY = (int) pos.getY();
            if (curY == 0) {
            } else {
                if (map.getValueAt(pos.getX(), curY - 1) != '1') {
                    pos.setY(curY - 1);
                }
            }
        }catch (Exception ex){}
    }
    @Override
    public void moveRight(){
        try {
            int curY = (int) pos.getY();
            if (curY == width) {
            } else {
                if (map.getValueAt(pos.getX(), curY + 1) != '1') {
                    pos.setY(curY + 1);
                }
            }
        }catch(Exception ex){}
    }
}

class Game{
    private Map map;
    private Player player;
    Game(Map map){
        this.map = map;
    }
    void addPlayer(Player player){
        this.player = player;
        setMap(map);
    }
    void setMap(Map map){
        player.setMap(map);
    }
}

class Map{
    private int length;
    private Scanner scan;
    private char[][] map;

    Map(Scanner scanner) throws InvalidMapException {
        scan = scanner;
        length = scan.nextInt();
        setValues();
    }
    char getValueAt(int q, int p){
        return map[q][p];
    }
    void print(){
        int i = 0;
        while (i<length){
            for(int g=0; g<length; g++){
                System.out.print(map[i][g] + " ");
            }
            System.out.println();
            i++;
        }
    }
    void setValues() throws InvalidMapException {
        int size = length;
        if(size==0){
            throw new InvalidMapException("Map size can not be zero");
        }
        map = new char[size][size];
        try{
            int i = 0;
            do{
                int j = 0;
                do{
                    String s = scan.next();
                    map[i][j] = s.charAt(s.length()-1);
                    char cur = map[i][j];
                    switch (cur){
                        case '0': break;
                        case '1': break;
                        case 'P': break;
                        default: throw new InvalidMapException("Not enough map elements");
                    }
                    j++;
                }while(j<size);
                i++;
            }while(i<size);
        }catch(Exception error){
            throw new InvalidMapException();
        }
    }
    int getSize(){
        return length;
    }
}

class InvalidMapException extends Exception{
    private final String message = "Not enough map elements";
    public InvalidMapException(){
    }

    public String getMessage(){
        return message;
    }
    public InvalidMapException(String warning){
        System.out.println(warning);
        System.exit(0);
    }
}

/*
DO NOT MODIFY THIS PART!!!
Input and Output has been done for you.
Various conditions are meant to check individual classes separately.
You still need to implement completely all the necessary classes with their corresponding methods,
but the correctness for each class is checked individually.
In other words, you already get some partial points for implementing some classes completely and correctly,
even if other classes are complete but still may not work properly.
*/
public class Solution{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();

        // Checking the implementation of the Position class
        if(className.equals("Position")){
            Position p1 = new Position(input.nextInt(), input.nextInt());
            System.out.println(p1);
            p1.setX(5);
            System.out.println(p1.getX());

            Position p2 = new Position(5, 10);
            System.out.println(p1.equals(p2));
        }

        // Checking the implementation of the Map class
        else if(className.equals("Map")){
            try{
                Map map = new Map(input);
                map.print();
                int size = map.getSize();
                System.out.println(size);
                System.out.println(map.getValueAt(size/2, size/2));
            }
            catch(Exception e){}
        }

        // Checking the Player interface and the MyPlayer class
        else if(className.equals("Player")){
            Player player = new MyPlayer();
            System.out.println(Player.class.isInterface());
            System.out.println(player instanceof Player);
            System.out.println(player instanceof MyPlayer);
        }

        // Checking the InvalidMapException class
        else if(className.equals("Exception")){
            try{
                throw new InvalidMapException("Some message");
            }
            catch(InvalidMapException e){
                System.out.println(e.getMessage());
            }
        }

        // Checking the Game class and all of its components
        else if(className.equals("Game")){

            // Initialize player, map, and the game
            Player player = new MyPlayer();
            Game game = null;

            try{
                game = new Game(new Map(input));
            }
            catch(InvalidMapException e){ // custom exception
                System.out.println(e.getMessage());
                System.exit(0);
            }

            game.addPlayer(player);

            // Make the player move based on the commands given in the input
            String moves = input.next();
            char move;
            for(int i=0; i<moves.length(); i++){
                move = moves.charAt(i);
                switch(move){
                    case 'R':
                        player.moveRight();
                        break;
                    case 'L':
                        player.moveLeft();
                        break;
                    case 'U':
                        player.moveUp();
                        break;
                    case 'D':
                        player.moveDown();
                        break;
                }
            }

            // Determine the final position of the player after completing all the moves above
            Position playerPosition = player.getPosition();
            System.out.println("Player final position");
            System.out.println("Row: " + playerPosition.getY());
            System.out.println("Col: " + playerPosition.getX());
        }
    }
}