package problem.algorithms;

/**
 * You are given an integer "height" and a list of integers "blacklist". You are
 * currently standind at height "height" and you are playin ga game to move a
 * small ball down to height 0.
 * In even rounds (0, 2, 4, 6 etc.) you can move the ball down "1", "2" or "4"
 * stairs down. In odd rounds you can move the ball down "1", "3" or "4" stairs.
 * There are some levels of the stairs where if the ball lands there, it will
 * die as labelled in "blacklist". Return the number of ways you can move the
 * ball down to height 0. Mod the result by 10 ** 9 + 7.
 * Constraints
 *  -> 1 <= height <= 100,000;
 *  -> 0 <= b <= 100,000 where b is the length of blacklist
 *
 *  Example 1:
 *  -> height = 4
 *  -> blacklist = [2]
 *  Output: 2
 *  Explanation:
 *      -> We can move 4 stairs down on round 0
 *      -> We can move 1 stair down on round 0 and then 3 stairs down on round 1.
 *
 * Example 2:
 *  -> height = 5
 *  -> blacklist = [0]
 *  Output: 0
 *  Explanation: There's no way to reach 0, since it's blacklisted.
 */

import java.util.HashMap;
import java.util.Arrays;

public class DropBallDownStairs {
    private int[] blacklist = null;
    private HashMap<Integer, int[]> memoizer = new HashMap<>();

    private boolean isBlacklisted(final int height) {
        return Arrays.binarySearch(blacklist, height) >= 0;
    }

    private int solve(final int height, final int currRound) {
        if (height < 0 || isBlacklisted(height)) {
            return 0;
        }

        if (height == 0) {
            return 1;
        }

        int oddOrEven = currRound % 2;
        if (memoizer.containsKey(height)) {
            var res = memoizer.get(height);
            if (res[oddOrEven] != -1) {
                return res[oddOrEven];
            }
        }

        int twoOrThree = 2 + oddOrEven;
        int res = solve(height - 1, currRound + 1) +
                solve(height - twoOrThree, currRound + 1) +
                solve(height - 4, currRound + 1);

        int[] resArray = {-1, -1};
        resArray[oddOrEven] = res;
        memoizer.put(height, resArray);

        return res;
    }

    public int solve(int height, int[] blacklist)  {
        this.blacklist = blacklist;
        Arrays.sort(blacklist);

        return solve(height, 0);
    }

}
