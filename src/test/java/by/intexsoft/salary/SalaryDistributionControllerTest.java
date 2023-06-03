package by.intexsoft.salary;

import by.intexsoft.salary.controller.SalaryDistributionController;
import by.intexsoft.salary.model.WorkedTime;
import by.intexsoft.salary.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tsimur Haidel
 */
@SpringBootTest
class SalaryDistributionControllerTest {

    private static final String URL_TEMPLATE = "/period/2023-03/distribute-salary";
    private MockMvc mockMvc;
    @Autowired
    private SalaryDistributionController controller;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testDistributeSalary() throws Exception {
        WorkedTime workedTime1 = new WorkedTime();
        workedTime1.setMitarbeiterId("1");
        workedTime1.setDauer(120);

        WorkedTime workedTime2 = new WorkedTime();
        workedTime2.setMitarbeiterId("2");
        workedTime2.setDauer(180);

        List<WorkedTime> workedTimes = Arrays.asList(workedTime1, workedTime2);

        mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(workedTimes)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mitarbeiterId").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].salary").value(2000.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].mitarbeiterId").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].salary").value(3600.0));
    }

}
