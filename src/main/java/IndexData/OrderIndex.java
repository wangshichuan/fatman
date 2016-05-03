package IndexData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import Model.OrderModel;

/**
 * 为order建立索引
 */
public class OrderIndex {

	public static void buildIndex(){
		SolrServer server = new HttpSolrServer("http://localhost:7000/solr/order");
		DataFromDB data = new DataFromDB();
		List<OrderModel> list = new ArrayList<OrderModel>();
		list = data.getOrderInfo();
		for (int i = 0; i < list.size(); i++) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.setField("id", list.get(i).getOrderid());
			doc.setField("userid", list.get(i).getUserid());
			doc.setField("totalprice", list.get(i).getTotalprice());
			doc.setField("time", list.get(i).getTime());
			doc.setField("userid", list.get(i).getUserid());
			doc.setField("username", list.get(i).getUsername());
			doc.setField("status", list.get(i).getStatus());
			doc.setField("paymethod", list.get(i).getPaymethod());
			doc.setField("orderaddress", list.get(i).getOrderaddress());
			doc.setField("orderusername", list.get(i).getOrderusername());
			doc.setField("orderphone", list.get(i).getOrderphone());
			try {
				server.add(doc);
				server.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		System.out.println("order index success");
		}
		
	public void delOrderById(Integer orderid){
		SolrServer server = new HttpSolrServer("http://localhost:7000/solr/order");
		try {
			server.deleteById(orderid.toString());
			server.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 运行main方法即可建立索引
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildIndex();
	}

}
