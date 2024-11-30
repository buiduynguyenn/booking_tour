export class Review {
    id!: number;
    userId!: number; // ID người dùng đã đánh giá
    tourId!: number; // ID tour được đánh giá
    rating!: number; // Đánh giá từ 1 đến 5
    comment!: string; // Bình luận của người dùng
}