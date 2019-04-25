/**
 * @author wangjialong
 * @date 2019年04月25日 12:06
 * @description 请输入描述
 */
public class Prim {
    public void prim(int start, MatrixUDG matrixUDG) {
        /**顶点个数*/
        int num = matrixUDG.getmVexs().length;
        /**prim最小树的索引，即prims数组的索引*/
        int index = 0;
        /**prim最小树的结果数组*/
        char[] prims = new char[num];
        /**weights顶点间边的权值*/
        int[] weight = new int[num];

        /**prim最小生成树中第一个数是“图中第start个顶点”，因为是从start开始的*/
        prims[index++] = matrixUDG.getmVexs()[start];

        /**初始化顶点的权值数组，将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值*/
        for (int i = 0; i < num; i++) {
            weight[i] = matrixUDG.getmMatrix()[start][i];
        }
        weight[start] = 0;

        for (int i = 0; i < num; i++) {
            /*由于从start开始的，因此不需要再对第start个顶点进行处理*/
            if (start == i) {
                continue;
            }
            int j = 0;
            /*第k个顶点权值最小*/
            int k = 0;
            int min = MatrixUDG.getINF();
            /*在未被加入到最小生成树的顶点中找出权值最小的顶点*/
            while (j < num) {
                if (weight[j] != 0 && weight[j] < min) {
                    min = weight[j];
                    k = j;
                }
                j++;
            }

            /*经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的第k个顶点*/
            /*将第k个顶点加入到最小生成树的结果数组中*/
            prims[index++] = matrixUDG.getmVexs()[k];
            /*将"第k个顶点的权值"标记为0，意味着第k个顶点已经加入到最小树结果中*/
            weight[k] = 0;
            /*当第k个顶点被加入到最小生成树的结果数组之后，选出其他顶点的最小权值*/
            for (j = 0; j < num; j++) {
                if (weight[j] != 0 && weight[j] > matrixUDG.getmMatrix()[k][j]) {
                    weight[j] = matrixUDG.getmMatrix()[k][j];
                }
            }
        }
            /*计算最小生成树的权值*/
        int sum = 0;
        /*m,n是记录每条边的路径*/
        int m = 0;
        int n = 0;
        for (int i = 1; i < index; i++) {
            int min = MatrixUDG.getINF();
                /*x是到达的顶点,因为是无向图（邻接矩阵为对称矩阵）所以 出发顶点到达顶点可以互换*/
             int x = getPosition(prims[i], matrixUDG);
            for (int j = 0; j < i; j++) {
                    /*y是出发的顶点*/
                int y = getPosition(prims[j], matrixUDG);
                if (min > matrixUDG.getmMatrix()[x][y]) {
                    min = matrixUDG.getmMatrix()[x][y];
                    m = x;
                    n = y;
                }
            }
        System.out.println(matrixUDG.getmVexs()[n] + "----------------->" + matrixUDG.getmVexs()[m]);
        sum += min;
        }


        System.out.printf("PRIM(%c)=%d: ", matrixUDG.getmVexs()[start], sum);
        for (int i = 0; i < index; i++) {
            System.out.printf("%c ", prims[i]);
        }
        System.out.printf("\n");


    }


    /**
     * @params [ch, matrixUDG]
     * @returns int
     * @description 获取顶点在邻接矩阵中数组的位置
     */
    private int getPosition(char ch, MatrixUDG matrixUDG) {

        for (int i = 0; i < matrixUDG.getmVexs().length; i++) {
            if (matrixUDG.getmVexs()[i] == ch) {
                return i;
            }
        }
        return -1;
    }
}
