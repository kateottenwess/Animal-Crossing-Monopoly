public class CommunityChest extends MiscSpaces {
    //possible community chest cards- should probably make like 10

    private int randIndex;
    //array of community chest cards
    private String communityCards[] = {"Grand Museaum Opening: Collect 50 coins from each player","Go To Jail","Get out of jail, free","Dug up a sack of gold! Collect 100 coins","Advance to Go: Collect 200 coins","Income tax refund: Collect 20 coins","You inheret 100 coins!","Tom Nook miscalculated your taxes, collect 200 coins!","Your village has won second in a beauty contest: collect 10 coins!", "Sahara stopped by, pay 100 coins"};
    
    //method for when player lands on Community Chest space
    public String pickUpCC(){
        randIndex = (int)(Math.random()*communityCards.length);

        return communityCards[randIndex];

    }


}
