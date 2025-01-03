// UC 13: Ensure Retrieve Queries Work with New Table Structure
public class TestRetrieveQueries {
    public static void main(String[] args) {
        // Test UC 6
        RetrieveByCityOrState.main(null);

        // Test UC 7
        GetSizeByCityState.main(null);

        // Test UC 8
        SortedEntriesByCity.main(null);

        // Test UC 10
        CountByType.main(null);
    }
}
