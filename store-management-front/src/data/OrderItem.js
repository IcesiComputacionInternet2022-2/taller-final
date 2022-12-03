import { currentUser } from './CurrentUser';

export const order = {
    userId: currentUser.userId, 
    total: 0,
    status: 'enviado',
    orderItem: [],
};