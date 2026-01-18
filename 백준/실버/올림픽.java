import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> list  = new ArrayList<>();

        Country country = null;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int num  = Integer.parseInt(st.nextToken());
            int gold  = Integer.parseInt(st.nextToken());
            int silver  = Integer.parseInt(st.nextToken());
            int bronze  = Integer.parseInt(st.nextToken());
            Country newCountry = new Country(num,gold,silver,bronze);
            list.add(newCountry);
            if(num==K){
                country = newCountry;
            }
        }

        int sum=1;
        for(int i=0;i<N;i++){
            Country targetCountry = list.get(i);

            if(targetCountry.gold > country.gold){
                sum++;
                continue;
            }
            if(targetCountry.gold == country.gold && targetCountry.silver > country.silver){
                sum++;
                continue;
            }

            if(targetCountry.gold == country.gold && targetCountry.silver == country.silver && targetCountry.bronze > country.bronze){
                sum++;
                continue;
            }

        }

        System.out.println(sum);

    }

    static class Country{
        int num;
        int gold;
        int silver;
        int bronze;

        public Country(int num, int gold, int silver, int bronze){
            this.num = num;
            this.gold = gold;
            this.silver =silver;
            this.bronze = bronze;
        }
    }
}
