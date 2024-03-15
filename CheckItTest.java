import org.junit.Test;
import static org.junit.Assert.*;

public class CheckItTest {

    // Predicate Coverage
    @Test
    public void predicateTrueWhenAIsTrue() {
        assertEquals("P is true", CheckIt.checkIt(true, false, false));
    }

    @Test
    public void predicateFalseWhenAllAreFalse() {
        assertEquals("P isn't true", CheckIt.checkIt(false, false, false));
    }

    // Clause Coverage
    @Test
    public void clauseAIsTrue() {
        assertEquals("P is true", CheckIt.checkIt(true, false, false));
    }

    @Test
    public void clauseAIsFalse() {
        assertEquals("P isn't true", CheckIt.checkIt(false, false, false));
    }

    @Test
    public void clauseBIsTrue() {
        assertEquals("P is true", CheckIt.checkIt(false, true, true));
    }

    @Test
    public void clauseBIsFalse() {
        assertEquals("P isn't true", CheckIt.checkIt(false, false, true));
    }

    @Test
    public void clauseCIsTrue() {
        assertEquals("P is true", CheckIt.checkIt(false, true, true));
    }

    @Test
    public void clauseCIsFalse() {
        assertEquals("P isn't true", CheckIt.checkIt(false, true, false));
    }

    // Correlated Active Clause Coverage (CACC)
    @Test
    public void caccAffectsOutcomeWhenAChanges() {
        assertEquals("P isn't true", CheckIt.checkIt(false, true, true));
        assertEquals("P is true", CheckIt.checkIt(true, true, true));
    }

    @Test
    public void caccAffectsOutcomeWhenBChanges() {
        assertEquals("P isn't true", CheckIt.checkIt(false, false, true));
        assertEquals("P is true", CheckIt.checkIt(false, true, true));
    }

    @Test
    public void caccAffectsOutcomeWhenCChanges() {
        assertEquals("P isn't true", CheckIt.checkIt(false, true, false));
        assertEquals("P is true", CheckIt.checkIt(false, true, true));
    }

    // Restrictive Active Clause Coverage (RACC)
    @Test
    public void raccAffectsOutcomeWhenAChanges() {
        assertEquals("P isn't true", CheckIt.checkIt(false, false, false));
        assertEquals("P is true", CheckIt.checkIt(true, false, false));
    }

    // For B and C, in RACC context, showing no change as they cannot change the outcome alone due to AND relationship
    @Test
    public void raccNoChangeWhenBChangesAlone() {
        assertEquals("P isn't true", CheckIt.checkIt(false, false, true));
    }

    @Test
    public void raccNoChangeWhenCChangesAlone() {
        assertEquals("P isn't true", CheckIt.checkIt(false, true, false));
    }
}
