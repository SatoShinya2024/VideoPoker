public class Print {
    public Print(int payout){
        if(payout == 800){
            System.out.println("ロイヤルストレートフラッシュ");
        }else if(payout == 50){
            System.out.println("ストレートフラッシュ");
        }else if(payout == 25){
            System.out.println("フォーカード");
        }else if(payout == 9){
            System.out.println("フルハウス");
        }else if(payout == 6){
            System.out.println("フラッシュ");
        }else if(payout == 4){
            System.out.println("ストレート");
        }else if(payout == 3){
            System.out.println("スリーカード");
        }else if(payout == 2){
            System.out.println("ツーペア");
        }else if(payout == 1){
            System.out.println("ジャックス以上のワンペア");
        }else if(payout == 0){
            System.out.println("ハイカード、またはテン以下のワンペア");
        }
    }
    
}
