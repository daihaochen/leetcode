package com.dhc.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haochen.Dai
 * @date Created in 2020/5/27 9:53
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Solution solution = new Solution();
        List<Integer> result = solution.gameCompatPagination(list, 0, 10, x -> x);
    }



    public <R, G> List<G> gameCompatPagination(List<R> data, Integer page, Integer size, trans<R, G> trans) {
        List<G> result = new ArrayList<>();
        int begin = page * size;
        int end = begin + size;
        if (begin + 1 > data.size()) {
            begin = data.size() - 1;
        }
        if (end > data.size()) {
            end = data.size();
        }
        for (int i = begin; i < end; i++) {
            result.add(trans.handle(data.get(i)));
        }
        return result;
    }


    interface trans<R, G> {
        G handle(R r);
    }

    class GameCompat {
        public String id;
        public String GameCompat;
    }

    class Game {
        public String id;
        public String Game;
    }

    GameCompat toGameCompat(Game game) {
        GameCompat gameCompat = new GameCompat();
        gameCompat.id = game.id;
        gameCompat.GameCompat = game.Game;
        return gameCompat;
    }
}
