import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CareerCounsellingGUI extends JFrame implements ActionListener {
    private JLabel[] skillLabels;
    private JSlider[] skillSliders;
    private JButton calculateButton;
    private JLabel resultLabel;

    // Skill weights for career suggestions
    private final int SCIENCE_WEIGHT = 3;
    private final int MATHS_WEIGHT = 3;
    private final int ORATION_WEIGHT = 2;
    private final int COMMUNICATION_WEIGHT = 2;
    private final int HISTORY_WEIGHT = 1;
    private final int SOCIAL_STUDIES_WEIGHT = 1;
    private final int LISTENING_WEIGHT = 2;
    private final int PROBLEM_SOLVING_WEIGHT = 3;
    private final int CREATIVITY_WEIGHT = 2;

    public CareerCounsellingGUI() {
        setTitle("Career Counselling");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        // Create skill labels and sliders
        String[] skillNames = {"Science", "Maths", "Oration", "Communication", "History", "Social Studies", "Listening", "Problem Solving", "Creativity"};
        int numSkills = skillNames.length;
        skillLabels = new JLabel[numSkills];
        skillSliders = new JSlider[numSkills];

        for (int i = 0; i < numSkills; i++) {
            skillLabels[i] = new JLabel(skillNames[i] + ": ");
            skillSliders[i] = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
            skillSliders[i].setMajorTickSpacing(1);
            skillSliders[i].setPaintTicks(true);
            skillSliders[i].setPaintLabels(true);
            add(skillLabels[i]);
            add(skillSliders[i]);
        }

        // Create calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Create result label
        resultLabel = new JLabel("");
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            // Compute individual scores
            int scienceScore = skillSliders[0].getValue() * SCIENCE_WEIGHT;
            int mathsScore = skillSliders[1].getValue() * MATHS_WEIGHT;
            int orationScore = skillSliders[2].getValue() * ORATION_WEIGHT;
            int communicationScore = skillSliders[3].getValue() * COMMUNICATION_WEIGHT;
            int historyScore = skillSliders[4].getValue() * HISTORY_WEIGHT;
            int socialStudiesScore = skillSliders[5].getValue() * SOCIAL_STUDIES_WEIGHT;
            int listeningScore = skillSliders[6].getValue() * LISTENING_WEIGHT;
            int problemSolvingScore = skillSliders[7].getValue() * PROBLEM_SOLVING_WEIGHT;
            int creativityScore = skillSliders[8].getValue() * CREATIVITY_WEIGHT;

            // Determine career types based on individual scores
            List<String> careerTypes = new ArrayList<>();

            if (scienceScore >= 24) {
                careerTypes.add("Scientist");
            }
            if (mathsScore >= 24) {
                careerTypes.add("Mathematician");
            }
            if (orationScore >= 16) {
                careerTypes.add("Orator");
            }
            if (communicationScore >= 16) {
                careerTypes.add("Communications Specialist");
            }
            if (historyScore >= 8) {
                careerTypes.add("Historian");
            }
            if (socialStudiesScore >= 8) {
                careerTypes.add("Social Studies Teacher");
            }
            if (listeningScore >= 16) {
                careerTypes.add("Counselor");
            }
            if (problemSolvingScore >= 24) {
                careerTypes.add("Engineer");
            }
            if (creativityScore >= 16) {
                careerTypes.add("Artist");
            }

            if (careerTypes.isEmpty()) {
                resultLabel.setText("No specific career type suggested.");
            } else {
                StringBuilder careerTypeBuilder = new StringBuilder("Recommended Career Types: ");
                for (String careerType : careerTypes) {
                    careerTypeBuilder.append(careerType).append(", ");
                }
                String suggestedCareerTypes = careerTypeBuilder.substring(0, careerTypeBuilder.length() - 2); // Remove the last comma and space
                resultLabel.setText(suggestedCareerTypes);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CareerCounsellingGUI();
            }
        });
    }
}
