// 2125 - Number of Laser Beams in a Bank

class Solution1 {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int previousBeam = 0;
        for(String it : bank){
            int currentBeam = 0;
            for(int i=0;i<it.length();i++){
                currentBeam += it.charAt(i) - '0';
            }
            if(currentBeam > 0){
                totalBeams += currentBeam * previousBeam;
                previousBeam = currentBeam;
            }
        }
        return totalBeams;
    }
}