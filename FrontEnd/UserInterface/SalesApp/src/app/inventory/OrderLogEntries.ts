import { Product } from '../product/product';
import { OrderEO } from './OrderEO';

export class OrderLogEntries {
    id:String;
	date:Date  ;
	username:String;
	orderEOs:OrderEO[];
	totalPrice:Number;
}

