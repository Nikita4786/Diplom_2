package diploma.utils;

public enum SqlQueries {

    SELECT_LAST_STATUS_DEBIT("SELECT pe.status FROM payment_entity pe ORDER BY pe.created DESC LIMIT 1;"),
    SELECT_LAST_STATUS_CREDIT("SELECT pe.status FROM credit_request_entity pe ORDER BY pe.created DESC LIMIT 1;"),
    SELECT_LAST_AMOUNT("SELECT pe.amount FROM payment_entity pe ORDER BY pe.created DESC LIMIT 1;");

    private final String sqlQuery;

    public String getSqlQuery() {
        return sqlQuery;
    }

    SqlQueries(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }


}
