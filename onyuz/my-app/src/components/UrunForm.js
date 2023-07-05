import React, { useState } from 'react';
import axios from 'axios';

const UrunForm = () => {
  const [urun, setUrun] = useState({
    urunId: '',
    urunTanim: '',
    urunFiyat: '',
    urunKategori: ''
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUrun({ ...urun, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8090/urun_yaz/yaz', urun);
      alert('Ürün başarıyla kaydedildi.');
      setUrun({
        urunId: '',
        urunTanim: '',
        urunFiyat: '',
        urunKategori: ''
      });
    } catch (error) {
      console.error(error);
      alert('Ürün kaydedilirken bir hata oluştu.');
    }
  };

  return (
    <div className="container">
      <h2 className="mt-4">Ürün Ekle</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="urunId" className="form-label">Ürün ID:</label>
          <input
            type="text"
            className="form-control"
            id="urunId"
            name="urunId"
            value={urun.urunId}
            onChange={handleInputChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="urunTanim" className="form-label">Ürün Tanımı:</label>
          <input
            type="text"
            className="form-control"
            id="urunTanim"
            name="urunTanim"
            value={urun.urunTanim}
            onChange={handleInputChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="urunFiyat" className="form-label">Ürün Fiyatı:</label>
          <input
            type="text"
            className="form-control"
            id="urunFiyat"
            name="urunFiyat"
            value={urun.urunFiyat}
            onChange={handleInputChange}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="urunKategori" className="form-label">Ürün Kategorisi:</label>
          <input
            type="text"
            className="form-control"
            id="urunKategori"
            name="urunKategori"
            value={urun.urunKategori}
            onChange={handleInputChange}
          />
        </div>
        <button type="submit" className="btn btn-primary">Kaydet</button>
      </form>
    </div>
  );
};

export default UrunForm;
