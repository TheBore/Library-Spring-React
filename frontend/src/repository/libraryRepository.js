import axios from '../custom-axios/axios';

const LibraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchCategories: () => {
        return axios.get("/categories");
    },

    fetchAuthors: () => {
        return axios.get("/authors");
    },

    addBook: (name,category,author,availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },

    editBook: (id,name,category,author,availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },

    takeCopyBook: (id) => {
        return axios.put(`/books/take-copy/${id}`);
    },

    getBook: (id) => {
        return axios.get(`/books/get-book/${id}`);
    }

}

export default LibraryService;