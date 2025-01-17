package api.interfaces;

public interface IForeignKey extends ICreateAtributes<IForeignKey>{
	/**
	 * @return the columnForeign
	 */
	public String getColumnForeign();
	/**
	 * @param columnBame the columnForeign to set
	 */
	public IForeignKey setColumnForeign( String columnForeign);
	/**
	 * @return the columnName
	 */
	public String getOriginColumnName();
	/**
	 * @param columnBame the columnBame to set
	 */
	public IForeignKey setOriginColumnName(String columnName);
	/**
	 * @return the tableForeign
	 */
	public String getTableForeign();
	/**
	 * @param tableForeign the tableForeign to set
	 */
	public IForeignKey setTableForeign(String tableForeign);
}
