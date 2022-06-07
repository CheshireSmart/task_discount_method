package task;

public class App 
{
    public static void main( String[] args )
    {
        
    }

    /**
    * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
    * на количество позиций readLength. Новые цены округляем “вниз”,
    * до меньшего целого числа.
    * @param price - исходные цены, цена должна быть больше нуля
    * @param discount - % скидки, должен попадать в диапазон от 1 до 99
    * @param offset - номер позиции, с которой нужно применить скидку, должен быть больше или равен нулю
    * @param readLength - количество позиций, к которым нужно применить скидку, должно быть больше нуля
    * @return - массив новых цен.
    * @throws Exception
    */
    public static int[] decryptData( int[] price, int discount, int offset, int readLength) throws Exception {
    
    if(discount > 0 && discount < 100 && readLength > 0) {
        if(offset >= 0 && (readLength + offset) <= price.length){

            int[] array = new int[readLength]; int y = 0;
            for(int i = offset ; i < offset + readLength  ; i++){
                if(price[i] > 0){
                    array[y] = (int) (price[i] - ((price[i]/100.0f) * discount));
                    y++;
                } else { throw new Exception("price("+price[i]+") is negative value or zero"); }
            }
            return array;

        } else { throw new Exception("offset is(" + offset + ") < 0 or offset + readLength = "+(offset+readLength)+" are out of range("+price.length+")"); }
            } else { throw new Exception ("discount range(" + discount + ") invalid or no readLength("+ readLength +")"); }
    }

}
