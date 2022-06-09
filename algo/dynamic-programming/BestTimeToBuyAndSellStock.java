

class BestTimeToBuyAndSellStock{

    public int maxProfit(int [] prices) {
        int result = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i < prices.length;i++) {
            minPrice = Math.min(minPrice, prices[i]);
            result = Math.max(prices[i] - minPrice, result);
        }
        return result;
    }

    public static void main(String args[]) {
        
    }

}