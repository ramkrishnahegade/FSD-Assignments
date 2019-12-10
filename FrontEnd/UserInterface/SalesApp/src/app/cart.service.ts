import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { OrderLogEntries } from './inventory/OrderLogEntries';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private _httpClient:HttpClient) { }

  
  getOrders(username:String):Observable<OrderLogEntries>{
    return this._httpClient.get<OrderLogEntries>('http://localhost:7173/sales/inventory-gateway/inventory/getOrders/'+username);
  }
}
