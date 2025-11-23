public class Player {
    private String name;
    private int lives;
    private int score;

    public Player(String name) {
        this.name = name;
        this.lives = 3;
        this.score = 0;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getLives() {
        return lives;
    }

    //in case its needed for custom lives
    public void setLives(int lives){
        this.lives = lives;
    }

    public int getScore(){
        return score;
    }

    public void loseLife(){
        lives--;
    }

    public void increaseScore(){
        score++;
    }

    // Lives > 0
    public boolean isAlive(){
        return lives > 0;
    }

}
