package lk.home.kulunu.dto;

import java.io.Serializable;

public class ExperiancePeriodDTO implements Serializable {

    private String candidateNic;
    private double period;

    public ExperiancePeriodDTO() {
    }

    public ExperiancePeriodDTO(String candidateNic, double period) {
        this.candidateNic = candidateNic;
        this.period = period;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public String getCandidateNic() {
        return candidateNic;
    }

    public void setCandidateNic(String candidateNic) {
        this.candidateNic = candidateNic;
    }

    @Override
    public String toString() {
        return "Test{" +
                "period=" + period +
                ", candidateNic='" + candidateNic + '\'' +
                '}';
    }
}
