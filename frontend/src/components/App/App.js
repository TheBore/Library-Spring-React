import './App.css';
import React, {Component} from 'react';
import Header from '../Header/header';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Books from '../Books/books'
import BooksAdd from '../Books/bookAdd'
import BooksEdit from '../Books/bookEdit'
import Categories from '../Categories/categories'
import LibraryService from "../../repository/libraryRepository";

class App extends Component{

  constructor(props) {
    super(props);
    this.state = {
      books: [],
      categories: [],
      authors: [],
      selectedBook: {}
    }
  }

  render(){
    return (
        <Router>
          <Header/>
          <main>
            <div className="container">
              <Route path={"/books"} exact render={() =>
                <Books books={this.state.books}
                       onDelete={this.deleteBook}
                       onEdit={this.getBook}
                       onTakeCopy={this.takeCopy}/>}/>
              <Route path={"/categories"} exact render={() =>
                  <Categories categories={this.state.categories}/>}/>
              <Route path={"/books/add"} exact render={() =>
                  <BooksAdd authors={this.state.authors}
                            categories={this.state.categories}
                            onAddBook={this.addBook}/>}/>
              <Route path={"/books/edit/:id"} exact render={() =>
                  <BooksEdit categories={this.state.categories}
                             authors={this.state.authors}
                             onEditBook={this.editBook}
                             book={this.state.selectedBook}/>}/>
              <Redirect to={"/books"}/>
            </div>
          </main>
        </Router>
    );
  }

  loadBooks = () => {
    LibraryService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }

  loadCategories = () => {
    LibraryService.fetchCategories()
        .then((data) => {
          this.setState({
            categories: data.data
          })
        });
  }

  loadAuthors = () => {
    LibraryService.fetchAuthors()
        .then((data) => {
          this.setState({
            authors: data.data
          })
        });
  }

    componentDidMount() {
        this.loadBooks();
        this.loadAuthors();
        this.loadCategories();
    }


    deleteBook = (id) => {
      LibraryService.deleteBook(id)
          .then(() => {
              this.loadBooks();
          });
  }

  addBook = (name,category,author,availableCopies) => {
      LibraryService.addBook(name,category,author,availableCopies)
          .then(() => {
              this.loadBooks();
          });
  }

  getBook = (id) => {
      LibraryService.getBook(id)
          .then((data) => {
              this.setState({
                  selectedBook: data.data
              })
          });
  }

  takeCopy = (id) => {
      LibraryService.takeCopyBook(id)
          .then(() => {
              this.loadBooks();
          });
  }

  editBook = (id,name,category,author,availableCopies) => {
      LibraryService.editBook(id,name,category,author,availableCopies)
          .then(() => {
              this.loadBooks();
          })
  }

}

export default App;
