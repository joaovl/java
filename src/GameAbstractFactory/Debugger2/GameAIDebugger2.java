package GameAbstractFactory.Debugger2;

import GameAbstractFactory.IAI;
import GameAbstractFactory.IRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joao on 08/02/2016.
 */
public class GameAIDebugger2 implements IAI {

    private static final int MAX_TEAMS     = 2;

    public String getGameAI() {
        return "AI for debugger2 game";
    }


    public List<Integer> playGame(IRules objRules, List<List<Integer>> cardsShuffled){
        //TODO - Find a more elegant way to present data here.
        List<Integer> player1 = cardsShuffled.get(0);
        List<Integer> player2 = cardsShuffled.get(1);
        List<Integer> player3 = cardsShuffled.get(2);
        List<Integer> player4 = cardsShuffled.get(3);

        //Start playing
        int teamA = 0, teamB = 0;
        List<Integer> rulesAnalysis = null;

        for( int i = 0; i < 10; i++) {

            rulesAnalysis = objRules.validPlay(player1);

            if ((rulesAnalysis.get(0) + player3.get(i)) < (player2.get(i) + player4.get(i))) {
                teamB = teamB + 2;
            } else if ((rulesAnalysis.get(0) + player3.get(i)) > (player2.get(i) + player4.get(i))) {
                teamA = teamA + 2;
            } else {
                teamA = teamA++;
                teamB = teamB++;
            }
            player1.set(rulesAnalysis.get(1), 0);
            player2.set(i, 0);
            player3.set(i, 0);
            player4.set(i, 0);
        }
        List<Integer> results = new ArrayList<>(MAX_TEAMS + 1);

        results.add(teamA);
        results.add(teamB);

        return results;
    }
}

