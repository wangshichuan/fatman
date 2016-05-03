package IndexData;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import Model.TypeModel;

public class TypeIndex {

	public static void buildIndex(){
		SolrServer server = new HttpSolrServer("http://localhost:8983/solr/collection1");
		DataFromDB data = new DataFromDB();
		List<TypeModel> list = new ArrayList<TypeModel>();
		list = data.getTypeInfo();
		for (int i = 0; i < list.size(); i++) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.setField("id", list.get(i).getTypeid());
			doc.setField("menuid", list.get(i).getMenuid());
			doc.setField("typename", list.get(i).getTypename());
			try {
				server.add(doc);
				server.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		System.out.println("����ɹ�");
		}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildIndex();
	}
}
