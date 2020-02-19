package torverbook.web.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import torverbook.web.db.QueriesGenerator.DB_ACTIONS;

public class DBActionResult {

	private final DB_ACTIONS action;
	/*
	 * HAS TO POSSIBLE TYPES: BOOLEAN (IF EXECUTE ACTION IS PROVIDED) &
	 * LIST<HASHMAP<STRING,OBJECT>> (IF QUERY ACTION IS PROVIDED)
	 */
	private final Object results;
	
	private final Logger logger = Logger.getLogger("DBActionResult");

	public DBActionResult() {
		action = DB_ACTIONS.UNDEFINED;
		results = null;
	}

	public DBActionResult(boolean actionSucceded) {
		action = DB_ACTIONS.EXECUTE;
		results = actionSucceded;
	}

	public DBActionResult(ResultSet actionResults) {
		action = DB_ACTIONS.QUERY;
		results = compileResultSetToListOfHashMaps(actionResults);
	}

	public Object getResults() {
		return results;
	}

	public DB_ACTIONS getActionType() {
		return action;
	}

	private Object compileResultSetToListOfHashMaps(ResultSet srcResultSet) {
		List<Map<String, Object>> compiledMapsList = new ArrayList<>();
		try {
			ResultSetMetaData metaData = srcResultSet.getMetaData();
			List<String> columnNames = getColumnNames(metaData);

			while (srcResultSet.next()) {
				compiledMapsList.add(compileHashMap(columnNames, srcResultSet));
			}
		} catch (SQLException ex) {
			logger.severe(ex.getMessage());
		}
		return compiledMapsList;
	}

	private List<String> getColumnNames(ResultSetMetaData metaData) throws SQLException {
		int columnsLength = metaData.getColumnCount();
		List<String> columnNames = new ArrayList<>();
		for (int colIndex = 0; colIndex < columnsLength; colIndex++) {
			columnNames.add(metaData.getColumnName(colIndex));
		}
		return columnNames;
	}

	private Map<String, Object> compileHashMap(List<String> columnNames, ResultSet resultSet) throws SQLException {
		Map<String, Object> compiledMap = new HashMap<>();
		for (String columnName : columnNames) {
			compiledMap.put(columnName, resultSet.getObject(columnName));
		}
		return compiledMap;
	}
	
}
