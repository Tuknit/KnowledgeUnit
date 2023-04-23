package model;

public class MonthDuration {
    
    private int totalDuration;
    private int beginningMonthDuration;
    private int analysisMonthDuration;
    private int designMonthDuration;
    private int executionMonthDuration;
    private int closureMonthDuration;
    private int followingAndControlMonthDuration;

    public MonthDuration(int totalDuration, int beginningMonthDuration, int analysisMonthDuration, int designMonthDuration, int executionMonthDuration, int closureMonthDuration, int followingAndControlMonthDuration){

        this.totalDuration = totalDuration;
        this.beginningMonthDuration = beginningMonthDuration;
        this.analysisMonthDuration = analysisMonthDuration;
        this.designMonthDuration = designMonthDuration;
        this.executionMonthDuration = executionMonthDuration;
        this.closureMonthDuration = closureMonthDuration;
        this.followingAndControlMonthDuration = followingAndControlMonthDuration;

    }

    public int getTotalDuration(){
        return totalDuration;
    }
    public int getBeginningMonthDuration(){
        return beginningMonthDuration;
    }

    public int getAnalysisMonthDuration(){
        return analysisMonthDuration;
    }

    public int getDesignMonthDuration(){
        return designMonthDuration;
    }

    public int getExecutionMonthDuration(){
        return executionMonthDuration;
    }

    public int getClosureMonthDuration(){
        return closureMonthDuration;
    }

    public int getFollowingAndControlMonthDuration(){
        return followingAndControlMonthDuration;
    }

}
