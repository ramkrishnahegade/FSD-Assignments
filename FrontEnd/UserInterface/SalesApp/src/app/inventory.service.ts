import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  constructor(private http: HttpClient) { }
  addOrder(username:String,productId:String):Observable<any> {
    return this.http.post('http://localhost:7173/sales/inventory-gateway/inventory/addOrder/'+username+'/'+productId,'');
}
}
