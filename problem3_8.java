package leetcode;

public class problem3_8 {
//    class Solution {
//        public boolean canFinish(int numCourses, int[][] prerequisites) {
//            //定义入度数组，索引处（课程号）对应入度，比如课程0的入度为0
//            int[] inDegree = new int[numCourses];
//            //定义map数组，key课程号，value：依赖key的课程号，比如key为1，依赖的value为3，4
//            Map<Integer,List<Integer>> map = new HashMap<>();
//            for(int i = 0; i < prerequisites.length;i++){
//                //遍历依赖关系表；在入度数组对应索引处++
//                inDegree[prerequisites[i][0]]++;
//                //没有对map初始化，这里对map初始化一个list数组，存放依赖的课程
          //关键之处，易搞错
//                map.putIfAbsent(prerequisites[i][1],new ArrayList<>());
//                //在对应被依赖课程key处添加依赖key的课程
//                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
//            }
//            //新建列表，把入度为0的课放进来
//            Queue<Integer> que = new LinkedList<>();
//            for(int i = 0 ; i <inDegree.length;i++){
//                if(inDegree[i]==0){
//                    que.offer(i);
//                }
//            }
//
//            while(!que.isEmpty()){
//                //弹出已选课程，在map找到依赖它的课程，在入度数组--
//                int course = que.poll();
//                numCourses--;
//                for(int nextCourse : map.getOrDefault(course,new ArrayList<>())){
//                    if(--inDegree[nextCourse]==0){
//                        que.offer(nextCourse);
//                    }
//                }
//            }
//            return numCourses==0;
//        }
//    }
}
