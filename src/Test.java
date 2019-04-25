/**
 * @author wangjialong
 * @date 2019年04月25日 15:14
 * @description 请输入描述
 */
public class Test {
    public static void main(String[] args) {
        char[] mVexs ={'A','B','C','D','E'};
        int[][]  mMatrix= {{0,1,2,Integer.MAX_VALUE,4},
                           {1,0,6,Integer.MAX_VALUE,8},
                           {2,6,0,10,Integer.MAX_VALUE},
                           {Integer.MAX_VALUE,Integer.MAX_VALUE,10,0,12},
                           {4,8,Integer.MAX_VALUE,12,0}};

        MatrixUDG matrixUDG = new MatrixUDG();
        matrixUDG.setmVexs(mVexs);
        matrixUDG.setmMatrix(mMatrix);


        new Prim().prim(3,matrixUDG);
    }
}
