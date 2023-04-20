import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Game {
    public static int score = 0;

    public ArrayList<Card> FirstHand(){
        ArrayList<Card> Cards = AllCards();
        ArrayList<Card> Hand = new ArrayList<>();
        int count = Cards.size();
        Random rnd = new Random();

        for(int i = 0; i < 5; i++){
            int num = rnd.nextInt(count);
            if(Hand.contains(Cards.get(num))){
                i--;
            }else{
                Hand.add(Cards.get(num));
            }
        }
        return Hand;
    }

    public ArrayList<Boolean> HoldOrChange(){
        ArrayList<Boolean> holdorchange = new ArrayList<>();
        holdorchange.add(true);
        holdorchange.add(true);
        holdorchange.add(true);
        holdorchange.add(true);
        holdorchange.add(true);
        
        return holdorchange;
    }

    public ArrayList<Card> handChange(ArrayList<Card> Hand, ArrayList<Boolean> holdList){
        int count = holdList.size();
        Random reRnd = new Random();
        ArrayList<Card> Cards = AllCards();

        for(int i = 0; i < count; i++){
            if(!holdList.get(i)){
                int reHand = reRnd.nextInt(Cards.size());
                while(Hand.contains(Cards.get(reHand))){
                    reHand = reRnd.nextInt(Cards.size());
                }
                Hand.set(i, Cards.get(reHand));
            }
        }

        return Hand;

    }

    public int Role(ArrayList<Card> Hand){
        int count = Hand.size();
        int pairAnalyzer = 1;
        boolean straightAnalyzer = true;
        boolean flushAnalyzer = false;
        boolean royal = false;
        boolean jacksOrBetter = false;
        ArrayList<Integer> numberList = new ArrayList<>();
        ArrayList<Character> suitList = new ArrayList<>(); 
        
        //ハンドの数字部分とスート部分を抜き出す
        for(int i = 0; i < count; i++){
            numberList.add(Hand.get(i).getNumber());
            suitList.add(Hand.get(i).getSuit());
        }

        //数字部分を昇順に並べ替え
        Collections.sort(numberList);     
        
        
        //ストレートの条件を定義
        for(int i = 0; i < numberList.size() - 1; i++){
            if(numberList.get(i) != numberList.get(i + 1) - 1){
                straightAnalyzer = false;
            }
        }
        //Aハイストレートの条件を定義
        if(numberList.get(0) == 1 && numberList.get(1) == 10 && numberList.get(2) == 11 && numberList.get(3) == 12 && numberList.get(4) == 13){
            straightAnalyzer = true;
            royal = true;
        }
        
        
        //フラッシュの条件を定義
        if(suitList.get(0) == suitList.get(1) && suitList.get(1) == suitList.get(2) && suitList.get(2)== suitList.get(3) && suitList.get(3) == suitList.get(4)){
            flushAnalyzer = true;
        }

        //数字部分を順番に抜き出し、ペアが揃っているかを確認。そのペアがジャックス以上かも確認。
        for(int i = 0; i < numberList.size() - 1; i++){
            if(numberList.get(i) == numberList.get(i + 1)){
                pairAnalyzer += 1;
                if(numberList.get(i) >= 11 || numberList.get(i) == 1){
                    jacksOrBetter = true;
                }
            }else{
                pairAnalyzer = pairAnalyzer * 10 + 1;
            }
        }
        
        //役の強さによって返値を定義。
        if(straightAnalyzer == true && flushAnalyzer == true){
            if(royal){
                return 800;
            }else{return 50;}
        }else if(pairAnalyzer == 14 || pairAnalyzer == 41){
            return 25;
        }else if(pairAnalyzer == 32 || pairAnalyzer == 23){
            return 9;
        }else if(flushAnalyzer){
            return 6;
        }else if(straightAnalyzer == true){
            return 4;
        }else if(pairAnalyzer == 311 || pairAnalyzer ==131 || pairAnalyzer == 113){
            return 3;
        }else if(pairAnalyzer == 221 || pairAnalyzer == 212 || pairAnalyzer == 122){
            return 2;
        }else if(pairAnalyzer == 2111 || pairAnalyzer == 1211 || pairAnalyzer == 1121 || pairAnalyzer == 1112){
            if(jacksOrBetter){
                return 1;
            }
            else{return 0;}
        }else{return 0;}

    }

    public ArrayList<Card> AllCards(){
        Card Cc1 = new Card("Cc1", 1, 'c', "src/card_club_01.png");
        Card Cc2 = new Card("Cc2", 2, 'c', "src/card_club_02.png");
        Card Cc3 = new Card("Cc3", 3, 'c', "src/card_club_03.png");
        Card Cc4 = new Card("Cc4", 4, 'c', "src/card_club_04.png");
        Card Cc5 = new Card("Cc5", 5, 'c', "src/card_club_05.png");
        Card Cc6 = new Card("Cc6", 6, 'c', "src/card_club_06.png");
        Card Cc7 = new Card("Cc7", 7, 'c', "src/card_club_07.png");
        Card Cc8 = new Card("Cc8", 8, 'c', "src/card_club_08.png");
        Card Cc9 = new Card("Cc9", 9, 'c', "src/card_club_09.png");
        Card Cc10 = new Card("Cc10", 10, 'c', "src/card_club_10.png");
        Card Cc11 = new Card("Cc11", 11, 'c', "src/card_club_11.png");
        Card Cc12 = new Card("Cc12", 12, 'c', "src/card_club_12.png");
        Card Cc13 = new Card("Cc13", 13, 'c', "src/card_club_13.png");
        
        Card Cd1 = new Card("Cd1", 1, 'd', "src/card_diamond_01.png");
        Card Cd2 = new Card("Cd2", 2, 'd', "src/card_diamond_02.png");
        Card Cd3 = new Card("Cd3", 3, 'd', "src/card_diamond_03.png");
        Card Cd4 = new Card("Cd4", 4, 'd', "src/card_diamond_04.png");
        Card Cd5 = new Card("Cd5", 5, 'd', "src/card_diamond_05.png");
        Card Cd6 = new Card("Cd6", 6, 'd', "src/card_diamond_06.png");
        Card Cd7 = new Card("Cd7", 7, 'd', "src/card_diamond_07.png");
        Card Cd8 = new Card("Cd8", 8, 'd', "src/card_diamond_08.png");
        Card Cd9 = new Card("Cd9", 9, 'd', "src/card_diamond_09.png");
        Card Cd10 = new Card("Cd10", 10, 'd', "src/card_diamond_10.png");
        Card Cd11 = new Card("Cd11", 11, 'd', "src/card_diamond_11.png");
        Card Cd12 = new Card("Cd12", 12, 'd', "src/card_diamond_12.png");
        Card Cd13 = new Card("Cd13", 13, 'd', "src/card_diamond_13.png");
        
        Card Ch1 = new Card("Ch1", 1, 'h', "src/card_heart_01.png");
        Card Ch2 = new Card("Ch2", 2, 'h', "src/card_heart_02.png");
        Card Ch3 = new Card("Ch3", 3, 'h', "src/card_heart_03.png");
        Card Ch4 = new Card("Ch4", 4, 'h', "src/card_heart_04.png");
        Card Ch5 = new Card("Ch5", 5, 'h', "src/card_heart_05.png");
        Card Ch6 = new Card("Ch6", 6, 'h', "src/card_heart_06.png");
        Card Ch7 = new Card("Ch7", 7, 'h', "src/card_heart_07.png");
        Card Ch8 = new Card("Ch8", 8, 'h', "src/card_heart_08.png");
        Card Ch9 = new Card("Ch9", 9, 'h', "src/card_heart_09.png");
        Card Ch10 = new Card("Ch10", 10, 'h', "src/card_heart_10.png");
        Card Ch11 = new Card("Ch11", 11, 'h', "src/card_heart_11.png");
        Card Ch12 = new Card("Ch12", 12, 'h', "src/card_heart_12.png");
        Card Ch13 = new Card("Ch13", 13, 'h', "src/card_heart_13.png");

        Card Cs1 = new Card("Cs1", 1, 's', "src/card_spade_01.png");
        Card Cs2 = new Card("Cs2", 2, 's', "src/card_spade_02.png");
        Card Cs3 = new Card("Cs3", 3, 's', "src/card_spade_03.png");
        Card Cs4 = new Card("Cs4", 4, 's', "src/card_spade_04.png");
        Card Cs5 = new Card("Cs5", 5, 's', "src/card_spade_05.png");
        Card Cs6 = new Card("Cs6", 6, 's', "src/card_spade_06.png");
        Card Cs7 = new Card("Cs7", 7, 's', "src/card_spade_07.png");
        Card Cs8 = new Card("Cs8", 8, 's', "src/card_spade_08.png");
        Card Cs9 = new Card("Cs9", 9, 's', "src/card_spade_09.png");
        Card Cs10 = new Card("Cs10", 10, 's', "src/card_spade_10.png");
        Card Cs11 = new Card("Cs11", 11, 's', "src/card_spade_11.png");
        Card Cs12 = new Card("CS12", 12, 's', "src/card_spade_12.png");
        Card Cs13 = new Card("CS13", 13, 's', "src/card_spade_13.png");

        ArrayList<Card> allCardList = new ArrayList<>();
        allCardList.add(Cc1);
        allCardList.add(Cc2);
        allCardList.add(Cc3);
        allCardList.add(Cc4);
        allCardList.add(Cc5);
        allCardList.add(Cc6);
        allCardList.add(Cc7);
        allCardList.add(Cc8);
        allCardList.add(Cc9);
        allCardList.add(Cc10);
        allCardList.add(Cc11);
        allCardList.add(Cc12);
        allCardList.add(Cc13);
        allCardList.add(Cd1);
        allCardList.add(Cd2);
        allCardList.add(Cd3);
        allCardList.add(Cd4);
        allCardList.add(Cd5);
        allCardList.add(Cd6);
        allCardList.add(Cd7);
        allCardList.add(Cd8);
        allCardList.add(Cd9);
        allCardList.add(Cd10);
        allCardList.add(Cd11);
        allCardList.add(Cd12);
        allCardList.add(Cd13);
        allCardList.add(Ch1);
        allCardList.add(Ch2);
        allCardList.add(Ch3);
        allCardList.add(Ch4);
        allCardList.add(Ch5);
        allCardList.add(Ch6);
        allCardList.add(Ch7);
        allCardList.add(Ch8);
        allCardList.add(Ch9);
        allCardList.add(Ch10);
        allCardList.add(Ch11);
        allCardList.add(Ch12);
        allCardList.add(Ch13);
        allCardList.add(Cs1);
        allCardList.add(Cs2);
        allCardList.add(Cs3);
        allCardList.add(Cs4);
        allCardList.add(Cs5);
        allCardList.add(Cs6);
        allCardList.add(Cs7);
        allCardList.add(Cs8);
        allCardList.add(Cs9);
        allCardList.add(Cs10);
        allCardList.add(Cs11);
        allCardList.add(Cs12);
        allCardList.add(Cs13);
        
        return allCardList;
    }


}
