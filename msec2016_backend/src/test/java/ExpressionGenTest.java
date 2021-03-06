import com.mifmif.common.regex.Generex;
import com.msec2016.expression.ExpressionGen;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by miao on 2016/9/25.
 */
public class ExpressionGenTest {

    private ExpressionGen expressionGen = new ExpressionGen();


    @Test
    public void addNewType() {
        assertThat(expressionGen.addNewType("\\+", "\\-"))
                .isEqualTo("(\\+|\\-)");

        assertThat(expressionGen.addNewType("(\\+|\\-)", "\\*"))
                .isEqualTo("((\\+|\\-)|\\*)");

    }

    @Test
    public void getSomeExpression() {
        expressionGen.setDataType(false, true, false);
        expressionGen.setOperatorType(true, false, false, false);

        expressionGen.setOperatorNum(1,2);

        Generex generex = expressionGen.getGenerex();


        List<String> ls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ls.add(generex.random());
        }

        for (String s : ls) {
            System.out.println(s + "    ,length:" + s.length());
            //assertThat(s.length()).isEqualTo(10);
        }
    }

}
