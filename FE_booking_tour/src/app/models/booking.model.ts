export class Booking {
    id!: number;
    userId!: number; // ID người dùng đã đặt tour
    tourId!: number; // ID tour đã đặt
    bookingDate!: Date; // Ngày đặt tour
    numberOfPeople!: number; // Số lượng người đặt tour
    totalPrice!: number; // Tổng giá trị đơn hàng
}