package IndexData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import Model.MenuModel;
import Model.UserModel;

/**
 * 为menu建立索引
 * @author Jack
 *
 */
public class MenuIndex {

	public static void buildIndex(){
		SolrServer server = new HttpSolrServer("http://localhost:7000/solr/menu");
		DataFromDB data = new DataFromDB();
		List<MenuModel> list = new ArrayList<MenuModel>();
		List<UserModel> listuser = new ArrayList<UserModel>();
		list = data.getMenuInfo();
		listuser = data.getUserInfo();
		for (int i = 0; i < (list.size()>listuser.size()?list.size():listuser.size()); i++) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.setField("id", list.get(i).getMenuid());
			if(i<list.size()){
			doc.setField("menuid", list.get(i).getMenuid());
			doc.setField("menuname", list.get(i).getMenuname());
			doc.setField("price", list.get(i).getPrice());
			doc.setField("describes", list.get(i).getDescribes());
			doc.setField("chengben", list.get(i).getChengben());
			doc.setField("picUrl", list.get(i).getPicUrl());
			doc.setField("typename", list.get(i).getTypename());
			}
//			if(i<listuser.size()){
//			doc.setField("userid", listuser.get(i).getUserid());
//			doc.setField("username", listuser.get(i).getUsername());
//			doc.setField("usernickname", listuser.get(i).getUsernickname());
//			doc.setField("phone", listuser.get(i).getPhone());
//			doc.setField("qq", listuser.get(i).getQq());
//			doc.setField("email", listuser.get(i).getEmail());
//			doc.setField("address", listuser.get(i).getAddress());
//			doc.setField("password", listuser.get(i).getPassword());
//			}
			try {
				server.add(doc);
				server.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}

		System.out.println("Index success");
		}
		/**
		 * 根据菜品id在索引中删除
		 * @param menuid
		 */
	public void deleteMenuById(Integer menuid){
		SolrServer server = new HttpSolrServer("http://localhost:7000/solr/menu");
		try {
			server.deleteById(menuid.toString());
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
