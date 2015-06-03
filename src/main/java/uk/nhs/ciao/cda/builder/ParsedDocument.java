package uk.nhs.ciao.cda.builder;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/**
 * The result of parsing a document into a collection of key/value properties.
 * <p>
 * When de-serialising instances of the class, Jackson uses the annotated constructor
 * of this class to determine which JSON properties to include.
 */
public class ParsedDocument {
	private final Document originalDocument;
	private final Map<String, Object> properties;
	
	/**
	 * Constructs a new parsed document from the specified original document
	 * and associated extracted properties
	 * 
	 * @param originalDocument The document that was parsed
	 * @param properties The extracted properties
	 */
	@JsonCreator
	public ParsedDocument(@JsonProperty("originalDocument") final Document originalDocument,
			@JsonProperty("properties") final Map<String, Object> properties) {
		this.originalDocument = Preconditions.checkNotNull(originalDocument);
		this.properties = Preconditions.checkNotNull(properties);
	}
	
	/**
	 * The document that was parsed
	 */
	public Document getOriginalDocument() {
		return originalDocument;
	}
	
	/**
	 * The key/value properties extracted from the document
	 */
	public Map<String, Object> getProperties() {
		return properties;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("originalDocument", originalDocument)
				.add("properties", properties)
				.toString();
	}
}
