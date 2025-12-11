class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer , ArrayList<Integer>> h1 = new HashMap<>() ;
        HashMap<Integer , ArrayList<Integer>> h2 = new HashMap<>() ;
        for(int i=0 ; i<buildings.length ; ++i){
            int x = buildings[i][0] ;
            int y = buildings[i][1] ;
            if(h1.containsKey(x)){
                h1.get(x).add(y);
            }else{
                h1.put(x , new ArrayList<>()) ;
                h1.get(x).add(y) ;
            }
            if(h2.containsKey(y)){
                h2.get(y).add(x);
            }else{
                h2.put(y , new ArrayList<>()) ;
                h2.get(y).add(x) ;
            }
        }
        for(int val : h1.keySet()){
            Collections.sort(h1.get(val)) ;
        }
        for(int val : h2.keySet()){
            Collections.sort(h2.get(val)) ;
        }
        int count = 0 ;
        for(int val : h1.keySet()){
            if(h1.get(val).size()<=2) continue ;
            for(int i=1 ; i<h1.get(val).size()-1 ; ++i){
                int x = val ;
                int y = h1.get(val).get(i) ;
                if(!h2.containsKey(y)) continue ;
                else{
                    if(h2.get(y).size()<=2) continue ;
                    if(h2.get(y).get(0)==x || h2.get(y).get(h2.get(y).size()-1)==x) continue ;
                    ++count ;
                }
            }
        }
        return count ;
    }
}