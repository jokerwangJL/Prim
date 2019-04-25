/**
 * @author wangjialong
 * @date 2019/4/25
 * @description 图邻接矩阵
 */

public class MatrixUDG {

    /**顶点集合*/
    private char[] mVexs;
    /**二维矩阵*/
    private int[][] mMatrix;//
    /**无穷大，表示两个顶点无边*/
    private static final int INF = Integer.MAX_VALUE ;


    public char[] getmVexs() {
        return mVexs;
    }

    public void setmVexs(char[] mVexs) {
        this.mVexs = mVexs;
    }

    public int[][] getmMatrix() {
        return mMatrix;
    }

    public void setmMatrix(int[][] mMatrix) {
        this.mMatrix = mMatrix;
    }

    public static int getINF() {
        return INF;
    }
}
