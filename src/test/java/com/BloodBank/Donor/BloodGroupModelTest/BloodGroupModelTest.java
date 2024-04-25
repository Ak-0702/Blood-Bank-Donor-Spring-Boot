package com.BloodBank.Donor.BloodGroupModelTest;
import com.BloodBank.Donor.model.BloodGroupModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloodGroupModelTest {

    @Test
    public void testBloodGroupModel() {
        BloodGroupModel bloodGroup = new BloodGroupModel();
        bloodGroup.setId(1L);
        bloodGroup.setType("A+");
        bloodGroup.setUnits(10);

        assertEquals(1L, bloodGroup.getId());
        assertEquals("A+", bloodGroup.getType());
        assertEquals(10, bloodGroup.getUnits());
    }
}
