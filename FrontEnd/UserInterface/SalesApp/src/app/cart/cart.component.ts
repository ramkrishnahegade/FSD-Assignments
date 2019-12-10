import { Component, OnInit } from '@angular/core';
import { OrderEO } from '../inventory/OrderEO';
import { User } from '../user';
import { CartService } from '../cart.service';
import { OrderLogEntries } from '../inventory/OrderLogEntries';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public dataSource:OrderEO[];
  totalPrice:Number;
  currentUser:User;
  public  displayedColumns: string[] = ['name', 'description', 'Total No Ordered','Order Price'];
  constructor(private _cartService:CartService) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this._cartService.getOrders(this.currentUser.username).subscribe( (data:OrderLogEntries)=>{
      this.dataSource=data.orderEOs;
      this.totalPrice=data.totalPrice;
      console.log(data);
    })
  }

}
