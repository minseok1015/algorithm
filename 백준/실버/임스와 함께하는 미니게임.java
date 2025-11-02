import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 신청 횟수
        String gameType = st.nextToken(); // 게임 종류

        // 1. 게임별 필요 인원(P) 설정
        int playersNeededPerGame = 0;
        if (gameType.equals("Y")) {
            playersNeededPerGame = 1; // 윷놀이: 임스 외 1명
        } else if (gameType.equals("F")) {
            playersNeededPerGame = 2; // 같은 그림 찾기: 임스 외 2명
        } else if (gameType.equals("O")) {
            playersNeededPerGame = 3; // 원카드: 임스 외 3명
        }

        // 2. 중복을 제거한 신청자(U) 계산
        Set<String> applicants = new HashSet<>();
        for (int i = 0; i < N; i++) {
            applicants.add(br.readLine());
        }

        int uniqueApplicants = applicants.size();

        // 3. 최대 게임 횟수 ( U / P ) 계산
        int maxGames = uniqueApplicants / playersNeededPerGame;

        System.out.println(maxGames);
    }
}