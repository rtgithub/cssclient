/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package njuseaurora.cssclient.businesslogicservice.gradeblservice;

import java.util.ArrayList;

import njuseaurora.cssclient.vo.gradevo.GradeVO;

/**
 *
 * @author Administrator
 */
public interface GradeBLService {

    public ArrayList<GradeVO> getCourseScore(String ID, String range);

    public double getGPA(String ID, String range);

    public int getGradeSum(String ID, String range);

    public boolean recordScore(String courseNum, ArrayList<GradeVO> scores);
}
